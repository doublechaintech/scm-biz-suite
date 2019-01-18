
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"潜在的客户", menuFor: "potentialCustomer",
  		subItems: [
  {name: 'potentialCustomerContactPersonList', displayName:'潜在客户联络人', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'potentialCustomerContactList', displayName:'潜在客户联系', icon:'om',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'eventAttendanceList', displayName:'活动的参与情况', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'potentialCustomer') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '手机', debugtype: 'string_china_mobile_phone', dataIndex: 'mobile', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '城市服务中心', dataIndex: 'cityServiceCenter', render: (text, record) => renderReferenceCell(text, record)},
  { title: '城市合伙人', dataIndex: 'cityPartner', render: (text, record) => renderReferenceCell(text, record)},
  { title: '描述', debugtype: 'string', dataIndex: 'description', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  mobile: '手机',
  cityServiceCenter: '城市服务中心',
  cityPartner: '城市合伙人',
  description: '描述',
  lastUpdateTime: '最后更新时间',

}


const PotentialCustomerBase={menuData,displayColumns,fieldLabels,displayColumns}
export default PotentialCustomerBase



