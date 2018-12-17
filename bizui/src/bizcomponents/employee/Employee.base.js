
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"员工", menuFor: "employee",
  		subItems: [
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
  
  		],
}

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
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '26',render: (text, record)=>renderTextCell(text,record) },

]

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
  currentStatus: '当前状态',

}


const EmployeeBase={menuData,displayColumns,fieldLabels,displayColumns}
export default EmployeeBase



