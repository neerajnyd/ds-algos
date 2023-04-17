package com.ny.klarna;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Transactions {

    /**
     * @param transactionsIn list of transactions made by customers
     * @param creditLimit    credit limit common to all customer
     * @return list of rejected transactions
     */
    public static List<String> findRejectedTransactions(List<String> transactionsIn, int creditLimit) {
        if (transactionsIn == null || transactionsIn.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Customer, List<Transaction>> customerToTransactions = new HashMap<>();
        transactionsIn.stream().map(s -> s.split(",")).forEach(arr -> {
            Customer customer = new Customer(arr[0], arr[1], arr[2]);
            Transaction transaction = new Transaction(Integer.parseInt(arr[3]), arr[4]);
            customerToTransactions
                    .computeIfAbsent(customer, c -> new ArrayList<>())
                    .add(transaction);
        });

        List<String> failedTransactions = new ArrayList<>();
        for (List<Transaction> transactions : customerToTransactions.values()) {
            int passTxnsValue = 0;
            for (Transaction transaction : transactions) {
                int creditConsumed = passTxnsValue + transaction.getAmount();
                if (creditConsumed > creditLimit) {
                    failedTransactions.add(transaction.getTransactionId());
                } else {
                    passTxnsValue = creditConsumed;
                }
                //if(passTxnsValue == creditLimit) then we can break and add all further transactions to failedTransactions
            }
        }
        /* the instructions don't say that the list of failed transactions need to be in a sorted order
            but a test case is failing with
            Expected: <[ TR009,  TR0026, TR0027, TR0035, TR0045]>
             Actual:  <[ TR0045, TR009,  TR0027, TR0026, TR0035]>
            So I can tell the expectation is to have a sorted list of transactions in non-descending order
         */
        failedTransactions.sort((o1, o2) -> {
            int t1 = Integer.parseInt(o1.substring(2));
            int t2 = Integer.parseInt(o2.substring(2));
            return Integer.compare(t1, t2);
        });
        return failedTransactions;
    }

    public static class Transaction {
        private final int amount;
        private final String transactionId;

        public Transaction(int amount, String transactionId) {
            this.amount = amount;
            this.transactionId = transactionId;
        }

        public int getAmount() {
            return amount;
        }

        public String getTransactionId() {
            return transactionId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Transaction that = (Transaction) o;

            return Objects.equals(transactionId, that.transactionId);
        }

        @Override
        public int hashCode() {
            return transactionId != null ? transactionId.hashCode() : 0;
        }
    }

    public static class Customer {
        private final String firstName;
        private final String lastName;
        private final String email;

        public Customer(String firstName, String lastName, String email) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Customer that = (Customer) o;

            if (!Objects.equals(firstName, that.firstName)) return false;
            if (!Objects.equals(lastName, that.lastName)) return false;
            return Objects.equals(email, that.email);
        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + (email != null ? email.hashCode() : 0);
            return result;
        }
    }

    @Test
    public void shouldReturnEmptyListIfThereIsNoTransactions() {
        assertThat(Transactions.findRejectedTransactions(new ArrayList<>(), 0).size(), is(0));
    }

    @Test
    public void shouldReturnEmptyListIfThereIsATransactionWithinCreditLimit() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,1,TR0001",
                "John,Doe,john@doe.com,200,TR0002"
        );

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions.size(), is(0));
    }

    @Test
    public void shouldReturnTransactionThatIsOverCreditLimit() {
        List<String> transactions = Arrays.asList("John,Doe,john@doe.com,201,TR0001");

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 200);

        assertThat(rejectedTransactions, is(Arrays.asList("TR0001")));
    }

    @Test
    public void shouldReturnTransactionsThatIsOverCreditLimitForMultipleCustomers() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,99,TR0002",
                "John,Doe,john@doe.com,100,TR0001",
                "John,Doe,john@doe.com,95,TR0003",
                "John,Doe,john@doe.com,7,TR0004",
                "Jane,Doe,jane@doe.com,11,TR0005",
                "John,Doe,john@doe.com,3,TR0006",
                "Jane,Doe,jane@doe.com,10,TR0007"
        );

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 10);

        assertThat(rejectedTransactions, is(Arrays.asList(
                "TR0001",
                "TR0002",
                "TR0003",
                "TR0005"
        )));
    }

    @Test
    public void shouldReturnTransactionsThatIsOverCreditLimitForMultipleCustomersOrderCheck() {
        List<String> transactions = Arrays.asList(
                "John,Doe,john@doe.com,99,TR009",
                "John,Doe,john@doe.com,7,TR0035",
                "Jane,Doe,jane@doe.com,11,TR0026",
                "John,Doe,john@doe.com,3,TR0045",
                "Jane,Doe,jane@doe.com,10,TR0027"
        );

        List<String> rejectedTransactions = Transactions.findRejectedTransactions(transactions, 0);

        assertThat(rejectedTransactions, is(Arrays.asList(
                "TR009",
                "TR0026",
                "TR0027",
                "TR0035",
                "TR0045"
        )));
    }

}
