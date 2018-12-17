
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"卡车司机", menuFor: "truckDriver",
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'truckDriver') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '驾驶执照号码', debugtype: 'string', dataIndex: 'driverLicenseNumber', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '联系电话', debugtype: 'string_china_mobile_phone', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '属于', dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  driverLicenseNumber: '驾驶执照号码',
  contactNumber: '联系电话',
  belongsTo: '属于',

}


const TruckDriverBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TruckDriverBase



