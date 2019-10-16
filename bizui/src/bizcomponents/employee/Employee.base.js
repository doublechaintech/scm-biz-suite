<<<<<<< HEAD

import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'


=======
import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854


const menuData = {menuName:"员工", menuFor: "employee",
  		subItems: [
<<<<<<< HEAD
  {name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeSkillList', displayName:'员工技能', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeePerformanceList', displayName:'员工绩效', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeWorkExperienceList', displayName:'员工工作经验', icon:'phoenix-framework',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeLeaveList', displayName:'请假记录', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeInterviewList', displayName:'员工面试', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeAttendanceList', displayName:'员工考勤', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeQualifierList', displayName:'员工资质', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeEducationList', displayName:'员工教育', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeAwardList', displayName:'员工嘉奖', icon:'award',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeSalarySheetList', displayName:'工资单', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'payingOffList', displayName:'工资支付', icon:'coffee',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
=======
  {name: 'employeeCompanyTrainingList', displayName:'员工参与的公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSkillList', displayName:'员工技能', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeePerformanceList', displayName:'员工绩效', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeWorkExperienceList', displayName:'员工工作经验', icon:'phoenix-framework',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeLeaveList', displayName:'请假记录', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeInterviewList', displayName:'员工面试', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAttendanceList', displayName:'员工考勤', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeQualifierList', displayName:'员工资质', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeEducationList', displayName:'员工教育', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeAwardList', displayName:'员工嘉奖', icon:'award',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'employeeSalarySheetList', displayName:'工资单', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'payingOffList', displayName:'工资支付', icon:'coffee',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  
  		],
}

<<<<<<< HEAD
const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 

}

const displayColumns = [
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'employee') },
  { title: '公司', dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record)},
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '部门', dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record)},
  { title: '姓', debugtype: 'string', dataIndex: 'familyName', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '名', debugtype: 'string', dataIndex: 'givenName', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '电子邮件', debugtype: 'string_email', dataIndex: 'email', width: '17',render: (text, record)=>renderTextCell(text,record) },
  { title: '城市', debugtype: 'string', dataIndex: 'city', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '地址', debugtype: 'string', dataIndex: 'address', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '手机', debugtype: 'string_china_mobile_phone', dataIndex: 'cellPhone', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '职业', dataIndex: 'occupation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '负责', dataIndex: 'responsibleFor', render: (text, record) => renderReferenceCell(text, record)},
  { title: '目前工资等级', dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record)},
  { title: '工资账户', debugtype: 'string', dataIndex: 'salaryAccount', width: '19',render: (text, record)=>renderTextCell(text,record) },
  { title: '工作申请', dataIndex: 'jobApplication', render: (text, record) => renderReferenceCell(text, record)},
  { title: '专业面试', dataIndex: 'professionInterview', render: (text, record) => renderReferenceCell(text, record)},
  { title: '人力资源部面试', dataIndex: 'hrInterview', render: (text, record) => renderReferenceCell(text, record)},
  { title: '审批工作要约', dataIndex: 'offerApproval', render: (text, record) => renderReferenceCell(text, record)},
  { title: '接受工作要约', dataIndex: 'offerAcceptance', render: (text, record) => renderReferenceCell(text, record)},
  { title: '员工入职', dataIndex: 'employeeBoarding', render: (text, record) => renderReferenceCell(text, record)},
  { title: '雇佣终止', dataIndex: 'termination', render: (text, record) => renderReferenceCell(text, record)},
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '26',render: (text, record)=>renderTextCell(text,record) },

]

=======

const settingMenuData = {menuName:"员工", menuFor: "employee",
  		subItems: [
  
  		],
}

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const fieldLabels = {
  id: '序号',
  company: '公司',
  title: '头衔',
  department: '部门',
  familyName: '姓',
  givenName: '名',
  email: '电子邮件',
  city: '城市',
  address: '地址',
  cellPhone: '手机',
  occupation: '职业',
  responsibleFor: '负责',
  currentSalaryGrade: '目前工资等级',
  salaryAccount: '工资账户',
  jobApplication: '工作申请',
  professionInterview: '专业面试',
  hrInterview: '人力资源部面试',
  offerApproval: '审批工作要约',
  offerAcceptance: '接受工作要约',
  employeeBoarding: '员工入职',
  termination: '雇佣终止',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}

<<<<<<< HEAD

const EmployeeBase={menuData,displayColumns,fieldLabels,displayColumns}
=======
const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'employee') , sorter: true },
  { title: fieldLabels.company, dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.department, dataIndex: 'department', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.familyName, debugtype: 'string', dataIndex: 'familyName', width: '5',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.givenName, debugtype: 'string', dataIndex: 'givenName', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.email, debugtype: 'string_email', dataIndex: 'email', width: '17',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.city, debugtype: 'string', dataIndex: 'city', width: '6',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.address, debugtype: 'string', dataIndex: 'address', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.cellPhone, debugtype: 'string_china_mobile_phone', dataIndex: 'cellPhone', width: '15',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.occupation, dataIndex: 'occupation', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.responsibleFor, dataIndex: 'responsibleFor', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.currentSalaryGrade, dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.salaryAccount, debugtype: 'string', dataIndex: 'salaryAccount', width: '19',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.jobApplication, dataIndex: 'jobApplication', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.professionInterview, dataIndex: 'professionInterview', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.hrInterview, dataIndex: 'hrInterview', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.offerApproval, dataIndex: 'offerApproval', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.offerAcceptance, dataIndex: 'offerAcceptance', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.employeeBoarding, dataIndex: 'employeeBoarding', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.termination, dataIndex: 'termination', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},
  { title: fieldLabels.currentStatus, debugtype: 'string', dataIndex: 'currentStatus', width: '26',render: (text, record)=>renderTextCell(text,record)},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(employee,targetComponent)=>{

  const userContext = null
  return (
    <div key={employee.id}>
	
      <DescriptionList  key={employee.id} size="small" col="4">
        <Description term="序号">{employee.id}</Description> 
        <Description term="头衔">{employee.title}</Description> 
        <Description term="部门"><div>{employee.department==null?appLocaleName(userContext,"NotAssigned"):`${employee.department.displayName}(${employee.department.id})`}
        </div></Description>
        <Description term="姓">{employee.familyName}</Description> 
        <Description term="名">{employee.givenName}</Description> 
        <Description term="电子邮件">{employee.email}</Description> 
        <Description term="城市">{employee.city}</Description> 
        <Description term="地址">{employee.address}</Description> 
        <Description term="手机">{employee.cellPhone}</Description> 
        <Description term="职业"><div>{employee.occupation==null?appLocaleName(userContext,"NotAssigned"):`${employee.occupation.displayName}(${employee.occupation.id})`}
        </div></Description>
        <Description term="负责"><div>{employee.responsibleFor==null?appLocaleName(userContext,"NotAssigned"):`${employee.responsibleFor.displayName}(${employee.responsibleFor.id})`}
        </div></Description>
        <Description term="目前工资等级"><div>{employee.currentSalaryGrade==null?appLocaleName(userContext,"NotAssigned"):`${employee.currentSalaryGrade.displayName}(${employee.currentSalaryGrade.id})`}
        </div></Description>
        <Description term="工资账户">{employee.salaryAccount}</Description> 
        <Description term="雇佣终止"><div>{employee.termination==null?appLocaleName(userContext,"NotAssigned"):`${employee.termination.displayName}(${employee.termination.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(employee.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
        <Description term="当前状态">{employee.currentStatus}</Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const EmployeeBase={menuData,displayColumns,fieldLabels,renderItemOfList}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
export default EmployeeBase



