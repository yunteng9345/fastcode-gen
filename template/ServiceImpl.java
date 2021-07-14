package impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jlpay.mpos.loan.dao.LoanHibernateConstants;

/**
 * ${remark}
 */
 
@Service(I${Table}Service.SERVER_NAME)
@Transactional(value=HibernateConstants.TRANSACTIONAL_ORACLE_MASTER_BEAN_NAME,readOnly=true)
public class ${Table}ServiceImpl implements I${Table}Service {

	@Autowired private ${Table}Dao ${table}Dao;
	public ${Table} get(String id) {
		return ${table}Dao.get(id);
	}
	
	public void delete(Long id){
		${table}Dao.delete(id);
	}

	@Transactional(value=HibernateConstants.TRANSACTIONAL_ORACLE_MASTER_BEAN_NAME,readOnly=false)
	public void save(${Table} ${table}) {
		${table}Dao.save(${table});
	}
	
	
	@Transactional(value=HibernateConstants.TRANSACTIONAL_ORACLE_MASTER_BEAN_NAME,readOnly=false)
	public void update(${Table} ${table}) {
		${table}Dao.update(${table});
	}

}
