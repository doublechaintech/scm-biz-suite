
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"会计凭证", menuFor: "accountingDocument",
  		subItems: [
  {name: 'originalVoucherList', displayName:'原始凭证', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountingDocumentLineList', displayName:'会计凭证行', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'accountingDocument') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '会计凭证日期', dataIndex: 'accountingDocumentDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '会计期间', dataIndex: 'accountingPeriod', render: (text, record) => renderReferenceCell(text, record)},
  { title: '文档类型', dataIndex: 'documentType', render: (text, record) => renderReferenceCell(text, record)},
  { title: '创建', dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '确认', dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '审计', dataIndex: 'auditing', render: (text, record) => renderReferenceCell(text, record)},
  { title: '过账', dataIndex: 'posting', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  accountingDocumentDate: '会计凭证日期',
  accountingPeriod: '会计期间',
  documentType: '文档类型',
  creation: '创建',
  confirmation: '确认',
  auditing: '审计',
  posting: '过账',
  currentStatus: '当前状态',

}


const AccountingDocumentBase={menuData,displayColumns,fieldLabels,displayColumns}
export default AccountingDocumentBase



