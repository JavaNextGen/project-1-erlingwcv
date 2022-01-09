package com.revature.results;

public class FMreimbViews {
	
	
	
	

}



//SELECT
//ers_reimbursement_status.reimb_status, 
//reimb_id,
//ers_users.user_last_name || ', ' || ers_users.user_first_name AS "Author", 
//reimb_type,
//reimb_amount, 
//reimb_submitted, 
//reimb_resolved, 
//reimb_description, 
//reimb_resolver
//FROM (((ers_reimbursement
//     JOIN ers_reimbursement_status ON ((ers_reimbursement.reimb_status_id = ers_reimbursement_status.reimb_status_id)))
//     JOIN ers_reimbursement_type ON ((ers_reimbursement.reimb_type_id = ers_reimbursement_type.reimb_type_id)))
//     JOIN ers_users ON ((ers_reimbursement.reimb_author = ers_users.ers_users_id)))
//WHERE ers_reimbursement.reimb_status_id = 1
