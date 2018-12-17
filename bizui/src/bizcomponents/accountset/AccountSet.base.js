
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"账套", menuFor: "accountSet",
  		subItems: [
  {name: 'accountingSubjectList', displayName:'会计科目', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountingPeriodList', displayName:'会计期间', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountingDocumentTypeList', displayName:'会计凭证类型', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'accountSet') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '年组', debugtype: 'string', dataIndex: 'yearSet', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '生效日期', dataIndex: 'effectiveDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '会计制度', debugtype: 'string', dataIndex: 'accountingSystem', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '本币代码', debugtype: 'string', dataIndex: 'domesticCurrencyCode', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '本币名称', debugtype: 'string', dataIndex: 'domesticCurrencyName', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '开户银行', debugtype: 'string', dataIndex: 'openingBank', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '帐户号码', debugtype: 'string', dataIndex: 'accountNumber', width: '18',render: (text, record)=>renderTextCell(text,record) },
  { title: '全国运营中心', dataIndex: 'countryCenter', render: (text, record) => renderReferenceCell(text, record)},
  { title: '双链小超', dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record)},
  { title: '产品供应商', dataIndex: 'goodsSupplier', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  yearSet: '年组',
  effectiveDate: '生效日期',
  accountingSystem: '会计制度',
  domesticCurrencyCode: '本币代码',
  domesticCurrencyName: '本币名称',
  openingBank: '开户银行',
  accountNumber: '帐户号码',
  countryCenter: '全国运营中心',
  retailStore: '双链小超',
  goodsSupplier: '产品供应商',

}


const AccountSetBase={menuData,displayColumns,fieldLabels,displayColumns}
export default AccountSetBase



