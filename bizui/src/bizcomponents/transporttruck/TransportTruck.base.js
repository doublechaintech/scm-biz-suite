
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"运输车", menuFor: "transportTruck",
  		subItems: [
  {name: 'transportTaskList', displayName:'运输任务', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'transportTruck') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '车牌号码', debugtype: 'string', dataIndex: 'plateNumber', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '联系电话', debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '汽车牌照号码', debugtype: 'string', dataIndex: 'vehicleLicenseNumber', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '发动机号', debugtype: 'string', dataIndex: 'engineNumber', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '制造日期', dataIndex: 'makeDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '里程', debugtype: 'string', dataIndex: 'mileage', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '车身颜色', debugtype: 'string', dataIndex: 'bodyColor', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '业主', dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  plateNumber: '车牌号码',
  contactNumber: '联系电话',
  vehicleLicenseNumber: '汽车牌照号码',
  engineNumber: '发动机号',
  makeDate: '制造日期',
  mileage: '里程',
  bodyColor: '车身颜色',
  owner: '业主',

}


const TransportTruckBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TransportTruckBase



