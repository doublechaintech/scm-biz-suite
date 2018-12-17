
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"双链小超省中心", menuFor: "retailStoreProvinceCenter",
  		subItems: [
  {name: 'provinceCenterEmployeeList', displayName:'省中心员工', icon:'align-center',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreCityServiceCenterList', displayName:'双链小超城市服务中心', icon:'city',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreProvinceCenter') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '成立', dataIndex: 'founded', render: (text, record) =>renderDateCell(text,record) },
  { title: '国', dataIndex: 'country', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  founded: '成立',
  country: '国',

}


const RetailStoreProvinceCenterBase={menuData,displayColumns,fieldLabels,displayColumns}
export default RetailStoreProvinceCenterBase



