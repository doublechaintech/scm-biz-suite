
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"供应订单", menuFor: "supplyOrder",
  		subItems: [
  {name: 'supplyOrderLineItemList', displayName:'供应订单行项目', icon:'line',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'supplyOrderShippingGroupList', displayName:'供应订单送货分组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'supplyOrderPaymentGroupList', displayName:'供应订单付款组', icon:'first-order',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'supplyOrder') },
  { title: '买方', dataIndex: 'buyer', render: (text, record) => renderReferenceCell(text, record)},
  { title: '卖方', dataIndex: 'seller', render: (text, record) => renderReferenceCell(text, record)},
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '14',render: (text, record)=>renderTextCell(text,record) },
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


const SupplyOrderBase={menuData,displayColumns,fieldLabels,displayColumns}
export default SupplyOrderBase



