
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"消费者订单", menuFor: "consumerOrder",
  		subItems: [
  {name: 'consumerOrderLineItemList', displayName:'消费者订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'consumerOrderShippingGroupList', displayName:'消费订单送货分组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'consumerOrderPaymentGroupList', displayName:'消费者订单付款组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'consumerOrderPriceAdjustmentList', displayName:'消费品价格调整', icon:'ad',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录', icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'consumerOrder') },
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '消费者', dataIndex: 'consumer', render: (text, record) => renderReferenceCell(text, record)},
  { title: '确认', dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '验收', dataIndex: 'approval', render: (text, record) => renderReferenceCell(text, record)},
  { title: '处理', dataIndex: 'processing', render: (text, record) => renderReferenceCell(text, record)},
  { title: '装运', dataIndex: 'shipment', render: (text, record) => renderReferenceCell(text, record)},
  { title: '送货', dataIndex: 'delivery', render: (text, record) => renderReferenceCell(text, record)},
  { title: '商场', dataIndex: 'store', render: (text, record) => renderReferenceCell(text, record)},
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  consumer: '消费者',
  confirmation: '确认',
  approval: '验收',
  processing: '处理',
  shipment: '装运',
  delivery: '送货',
  store: '商场',
  lastUpdateTime: '最后更新时间',
  currentStatus: '当前状态',

}


const ConsumerOrderBase={menuData,displayColumns,fieldLabels}
export default ConsumerOrderBase



