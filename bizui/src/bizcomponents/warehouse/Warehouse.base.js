
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"仓库", menuFor: "warehouse",
  		subItems: [
  {name: 'storageSpaceList', displayName:'存货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'smartPalletList', displayName:'智能托盘', icon:'pallet',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'supplierSpaceList', displayName:'供应商的空间', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'receivingSpaceList', displayName:'收货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'shippingSpaceList', displayName:'发货区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'damageSpaceList', displayName:'残次货物存放区', icon:'backspace',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'warehouseAssetList', displayName:'仓库资产', icon:'warehouse',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'warehouse') },
  { title: '位置', debugtype: 'string', dataIndex: 'location', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '联系电话', debugtype: 'string', dataIndex: 'contactNumber', width: '15',render: (text, record)=>renderTextCell(text,record) },
  { title: '总面积', debugtype: 'string', dataIndex: 'totalArea', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '业主', dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record)},
  { title: '纬度', debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '经度', debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  location: '位置',
  contactNumber: '联系电话',
  totalArea: '总面积',
  owner: '业主',
  latitude: '纬度',
  longitude: '经度',

}


const WarehouseBase={menuData,displayColumns,fieldLabels,displayColumns}
export default WarehouseBase



