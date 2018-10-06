package com.hrm.provider;


import static com.hrm.utils.HrmConstants.EMPLOYEETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Employee;


/**
 * @Description: 员工动态SQL语句提供类
 * @author Nier
 *
 */
public class EmployeeDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(EMPLOYEETABLE);
				System.out.println("开始查找");
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					
					if(employee.getDept() != null && employee.getDept().getDeptId() != null && employee.getDept().getDeptId() != -1){
						WHERE(" deptId = #{employee.dept.deptId} ");
					}
					if(employee.getJob() != null && employee.getJob().getPositionId() != -1){
						WHERE(" positionId = #{employee.job.positionId} ");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE(" name LIKE CONCAT ('%',#{employee.name},'%') ");
					}
					if(employee.getTelephone() != null && !employee.getTelephone().equals("")){
						WHERE(" telephone LIKE CONCAT ('%',#{employee.telephone},'%') ");
					}
					if(employee.getCodeId() != null && !employee.getCodeId().equals("") ){
						WHERE(" codeId LIKE CONCAT ('%',#{employee.codeId},'%') ");
					}
					if(employee.getGender() != null && employee.getGender() != -1){
						WHERE("gender = #{employee.gender}");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		System.out.println(sql);
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(EMPLOYEETABLE);
				if(params.get("employee") != null){
					Employee employee = (Employee)params.get("employee");
					if(employee.getDept() != null && employee.getDept().getDeptId() != null && employee.getDept().getDeptId() != 0){
						WHERE(" deptId = #{employee.dept.deptId} ");
					}
					if(employee.getJob() != null && employee.getJob().getPositionId() != -1){
						WHERE(" positionId = #{employee.job.positionId} ");
					}
					if(employee.getName() != null && !employee.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{employee.name},'%') ");
					}
					if(employee.getTelephone() != null && !employee.getTelephone().equals("")){
						WHERE(" telephone LIKE CONCAT ('%',#{employee.telephone},'%') ");
					}
					if(employee.getCodeId() != null && !employee.getCodeId().equals("") ){
						WHERE(" codeId LIKE CONCAT ('%',#{employee.codeId},'%') ");
					}
					if(employee.getGender() != null){
						WHERE("gender = #{employee.gender}");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertEmployee(Employee employee){
		
		return new SQL(){
			{
				INSERT_INTO(EMPLOYEETABLE);
				if(employee.getName() != null){
					VALUES("name", "#{name}");
				}
				if(employee.getCodeId() != null){
					VALUES("codeId", "#{codeId}");
				}
				if(employee.getAddress()!= null){
					VALUES("address", "#{address}");
				}
				if(employee.getPostCode()!= null){
					VALUES("postCode", "#{postCode}");
				}
				if(employee.getTelephone()!= null){
					VALUES("telephone", "#{telephone}");
				}
				if(employee.getEmail()!= null){
					VALUES("email", "#{email}");
				}
				if(employee.getGender()!= -1){
					VALUES("gender", "#{gender}");
				}
				if(employee.getParty()!= null){
					VALUES("party", "#{party}");
				}
				if(employee.getBirthday()!= null){
					VALUES("birthday", "#{birthday}");
				}
				if(employee.getRace()!= null){
					VALUES("race", "#{race}");
				}
				if(employee.getRemark()!= null){
					VALUES("remark", "#{remark}");
				}
				if(employee.getBasePay()!= -1){
					VALUES("basePay", "#{basePay}");
				}
				if(employee.getMajor()!= null){
					VALUES("major", "#{major}");
				}
				if(employee.getDept()!= null){
					VALUES("deptId", "#{dept.deptId}");
				}
				if(employee.getJob()!= null){
					VALUES("positionId", "#{job.positionId}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateEmployee(Employee employee){
		
		return new SQL(){
			{
				UPDATE(EMPLOYEETABLE);
				if(employee.getName() != null){
					SET(" name = #{name} ");
				}
				if(employee.getCodeId() != null){
					SET(" codeId = #{codeId} ");
				}
				if(employee.getAddress()!= null){
					SET(" address = #{address} ");
				}
				if(employee.getPostCode()!= null){
					SET(" postCode = #{postCode} ");
				}
				if(employee.getTelephone()!= null){
					SET(" telephone = #{telephone} ");
				}
				if(employee.getEmail()!= null){
					SET(" email = #{email} ");
				}
				if(employee.getGender()!= -1){
					SET(" gender = #{gender} ");
				}
				if(employee.getParty()!= null){
					SET(" party = #{party} ");
				}
				if(employee.getBirthday()!= null){
					SET(" birthday = #{birthday} ");
				}
				if(employee.getRace()!= null){
					SET(" race = #{race} ");
				}
				if(employee.getRemark()!= null){
					SET(" remark = #{remark} ");
				}
				if(employee.getMajor()!= null){
					SET(" major = #{major} ");
				}
				if(employee.getBasePay()!= -1){
					SET(" basePay = #{basePay} ");
				}
				if(employee.getDept()!= null){
					SET(" deptId = #{dept.deptId} ");
				}
				if(employee.getJob()!= null){
					SET(" positionId = #{job.positionId} ");
				}
				WHERE(" empId = #{empId} ");
			}
		}.toString();
	}


}
