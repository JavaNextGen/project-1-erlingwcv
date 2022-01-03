package com.revature.services;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * The ReimbursementService should handle the submission, processing,
 * and retrieval of Reimbursements for the ERS application.
 *
 * {@code process} and {@code getReimbursementsByStatus} are the minimum methods required;  // Both on Manager's Menu
 * however, additional methods can be added.
 *    
 * Examples:
 * <ul>
 *     <li>Create Reimbursement</li>  // 
 *     <li>Update Reimbursement</li>  // 
 *     <li>Get Reimbursements by ID</li>  // fin mgr only
 *     <li>Get Reimbursements by Author</li>   // fin mgr only
 *     <li>Get Reimbursements by Resolver</li> // fin mgr only
 *     <li>Get All Reimbursements</li>          // fin mgr only
 *     
 *             getReimbursementsByStatus       // fin mgr only: required
 * </ul>
 */
public class ReimbursementService {

		// Instantiate a Reimb DAO
	
		ReimbursementDAO rDAO = new ReimbursementDAO();
	
	
    /**
     * <ul>
     *     <li>Should ensure that the user is logged in as a Finance Manager</li>
     *     <li>Must throw exception if user is not logged in as a Finance Manager</li>
     *     <li>Should ensure that the reimbursement request exists</li>
     *     <li>Must throw exception if the reimbursement request is not found</li>
     *     <li>Should persist the updated reimbursement status with resolver information</li>
     *     <li>Must throw exception if persistence is unsuccessful</li>
     * </ul>
     *
     * Note: unprocessedReimbursement will have a status of PENDING, a non-zero ID and amount, and a non-null Author.
     * The Resolver should be null. Additional fields may be null.
     * After processing, the reimbursement will have its status changed to either APPROVED or DENIED.    // Menu item 2
     */
    public Reimbursement process(Reimbursement unprocessedReimbursement, Status finalStatus, User resolver) {
        return null;
    }

    // ================Process Reimbursements by Fin Manager ========================
    //* After processing, the reimbursement will have its status changed to either APPROVED or DENIED.
    
    
    
    
    
    
    // ================Reimb By Status======Fin Manager Only===========================================================
    /**
     * Should retrieve all reimbursements with the correct status.
     */
    public List<Reimbursement> getReimbursementsByStatus(Status status) {
    	
    	return rDAO.getByStatus(status);
//    	List<Reimbursement> gbs = rDAO.getByStatus(status);
//    	if (gbs.isEmpty() == false) {
//    		return gbs;
//    	} else {
    		
    	  	
//        return Collections.emptyList();
//    	}
    }
    
    
    // =========Employee=======Create New Reimb =================================================================================
    
    public void create(Reimbursement nReimb) {
    	
    	rDAO.createReimb(nReimb);
    	
    	
    }
    
    
    // =========Employee Update Unprocessed Reimbursement =========================
    
    
    public Reimbursement updateReimb(Reimbursement unprocessed) {
    	
    	return rDAO.update(unprocessed);
    }
    
}
