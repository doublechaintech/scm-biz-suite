
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"双链小超全国运营中心", menuFor: "retailStoreCountryCenter",
  		subItems: [
  {name: 'reportList', displayName:'报告', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'catalogList', displayName:'目录', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreProvinceCenterList', displayName:'双链小超省中心', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreList', displayName:'双链小超', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreMemberList', displayName:'生超会员', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'goodsSupplierList', displayName:'产品供应商', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'supplyOrderList', displayName:'供应订单', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'warehouseList', displayName:'仓库', icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportFleetList', displayName:'运输车队', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountSetList', displayName:'账套', icon:'headset',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'levelOneDepartmentList', displayName:'一级部门', icon:'bone',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'instructorList', displayName:'讲师', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreCountryCenter') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '服务号码', debugtype: 'string', dataIndex: 'serviceNumber', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '成立', dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record) },
  { title: '网站', debugtype: 'string_url', dataIndex: 'webSite', width: '36',render: (text, record)=>renderTextCell(text,record) },
  { title: '地址', debugtype: 'string', dataIndex: 'address', width: '18',render: (text, record)=>renderTextCell(text,record) },
  { title: '由', debugtype: 'string', dataIndex: 'operatedBy', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '法定代表人', debugtype: 'string', dataIndex: 'legalRepresentative', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '描述', debugtype: 'string', dataIndex: 'description', width: '17',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  serviceNumber: '服务号码',
  founded: '成立',
  webSite: '网站',
  address: '地址',
  operatedBy: '由',
  legalRepresentative: '法定代表人',
  description: '描述',

}


const RetailStoreCountryCenterBase={menuData,displayColumns,fieldLabels,displayColumns}
export default RetailStoreCountryCenterBase



