
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"货物", menuFor: "goods",
  		subItems: [
  {name: 'goodsMovementList', displayName:'货物移动', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goods') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'RFID', debugtype: 'string', dataIndex: 'rfid', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '计量单位', debugtype: 'string', dataIndex: 'uom', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '最大包装', debugtype: 'int', dataIndex: 'maxPackage', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '到期时间', dataIndex: 'expireTime', render: (text, record) =>renderDateCell(text,record) },
  { title: 'SKU', dataIndex: 'sku', render: (text, record) => renderReferenceCell(text, record)},
  { title: '收货区', dataIndex: 'receivingSpace', render: (text, record) => renderReferenceCell(text, record)},
  { title: '货位', dataIndex: 'goodsAllocation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '智能托盘', dataIndex: 'smartPallet', render: (text, record) => renderReferenceCell(text, record)},
  { title: '发货区', dataIndex: 'shippingSpace', render: (text, record) => renderReferenceCell(text, record)},
  { title: '运输任务', dataIndex: 'transportTask', render: (text, record) => renderReferenceCell(text, record)},
  { title: '双链小超', dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record)},
  { title: '订单', dataIndex: 'bizOrder', render: (text, record) => renderReferenceCell(text, record)},
  { title: '生超的订单', dataIndex: 'retailStoreOrder', render: (text, record) => renderReferenceCell(text, record)},
  { title: '包装', dataIndex: 'packaging', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '10',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  rfid: 'RFID',
  uom: '计量单位',
  maxPackage: '最大包装',
  expireTime: '到期时间',
  sku: 'SKU',
  receivingSpace: '收货区',
  goodsAllocation: '货位',
  smartPallet: '智能托盘',
  shippingSpace: '发货区',
  transportTask: '运输任务',
  retailStore: '双链小超',
  bizOrder: '订单',
  retailStoreOrder: '生超的订单',
  packaging: '包装',
  currentStatus: '当前状态',

}


const GoodsBase={menuData,displayColumns,fieldLabels}
export default GoodsBase



