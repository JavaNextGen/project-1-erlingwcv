package com.revature.models;

/**
 * Reimbursements within the ERS application transition through the following statuses:
 * <ul>
 *     <li>Pending</li>
 *     <li>Approved</li>
 *     <li>Denied</li>
 * </ul>
 *
 * Once reimbursements are processed, their final status cannot be changed.
 * A new reimbursement must be submitted.
 *
 * @author Center of Excellence
 */
public enum Status {

    PENDING {
        @Override
        public String toString() {
            return "Pending";
        }
        
        // to quickly get the value for DB query
        public int toInt() {
        	return 1;
        }
    },
    APPROVED {
        @Override
        public String toString() {
            return "Approved";
        }
        
     // to quickly get the value for DB query
        public int toInt() {
        	return 2;
        }
    },
    DENIED {
        @Override
        public String toString() {
            return "Denied";
        }
        
     // to quickly get the value for DB query
        public int toInt() {
        	return 3;
        }
        
    }
}
