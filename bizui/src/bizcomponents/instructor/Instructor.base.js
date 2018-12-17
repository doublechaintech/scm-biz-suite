
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"讲师", menuFor: "instructor",
  		subItems: [
  {name: 'companyTrainingList', displayName:'公司培训', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'instructor') },
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '姓', debugtype: 'string', dataIndex: 'familyName', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '名', debugtype: 'string', dataIndex: 'givenName', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '手机', debugtype: 'string_china_mobile_phone', dataIndex: 'cellPhone', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '电子邮件', debugtype: 'string_email', dataIndex: 'email', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '公司', dataIndex: 'company', render: (text, record) => renderReferenceCell(text, record)},
  { title: '介绍', debugtype: 'string', dataIndex: 'introduction', width: '19',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  familyName: '姓',
  givenName: '名',
  cellPhone: '手机',
  email: '电子邮件',
  company: '公司',
  introduction: '介绍',

}


const InstructorBase={menuData,displayColumns,fieldLabels,displayColumns}
export default InstructorBase



