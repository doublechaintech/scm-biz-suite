
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"工资单", menuFor: "employeeSalarySheet",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
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


const formatMoney=(amount)=>{
	const options={style: 'decimal',minimumFractionDigits: 2,maximumFractionDigits:2}
    const moneyFormat = new Intl.NumberFormat('en-US',options);
	return moneyFormat.format(amount)
	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${formatMoney(value)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? <span style={{fontWeight:"bold"}} title={`${value.id} - ${value.displayName}`} >{value.displayName}</span> : appLocaleName(userContext,"NotAssigned")) 

}

const displayColumns = [
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '员工', dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record)},
  { title: '目前工资等级', dataIndex: 'currentSalaryGrade', render: (text, record) => renderReferenceCell(text, record)},
  { title: '基本工资', dataIndex: 'baseSalary', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '奖金', dataIndex: 'bonus', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '奖励', dataIndex: 'reward', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '个人所得税', dataIndex: 'personalTax', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '社会保险', dataIndex: 'socialSecurity', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '住房公积金', dataIndex: 'housingFound', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '失业保险', dataIndex: 'jobInsurance', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '工资支付', dataIndex: 'payingOff', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '12',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  employee: '员工',
  currentSalaryGrade: '目前工资等级',
  baseSalary: '基本工资',
  bonus: '奖金',
  reward: '奖励',
  personalTax: '个人所得税',
  socialSecurity: '社会保险',
  housingFound: '住房公积金',
  jobInsurance: '失业保险',
  payingOff: '工资支付',
  currentStatus: '当前状态',

}


const EmployeeSalarySheetBase={menuData,displayColumns,fieldLabels}
export default EmployeeSalarySheetBase



