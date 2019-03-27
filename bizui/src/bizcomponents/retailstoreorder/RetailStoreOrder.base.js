
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"生超的订单", menuFor: "retailStoreOrder",
  		subItems: [
  {name: 'retailStoreOrderLineItemList', displayName:'双链小超订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreOrderShippingGroupList', displayName:'生超订单送货分组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreOrderPaymentGroupList', displayName:'生超订单付款组', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreOrder') },
  { title: '买方', dataIndex: 'buyer', render: (text, record) => renderReferenceCell(text, record)},
  { title: '卖方', dataIndex: 'seller', render: (text, record) => renderReferenceCell(text, record)},
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '18',render: (text, record)=>renderTextCell(text,record) },
  { title: '总金额', dataIndex: 'totalAmount', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '确认', dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '验收', dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record)},
  { title: '处理', dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record)},
  { title: '捡货', dataIndex: 'picking', render: (text, record) => renderReferenceCell(text, record)},
  { title: '装运', dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record)},
  { title: '送货', dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record)},
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  buyer: '买方',
  seller: '卖方',
  title: '头衔',
  totalAmount: '总金额',
  confirmation: '确认',
  approval: '验收',
  processing: '处理',
  picking: '捡货',
  shipment: '装运',
  delivery: '送货',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}


const RetailStoreOrderBase={menuData,displayColumns,fieldLabels}
export default RetailStoreOrderBase



