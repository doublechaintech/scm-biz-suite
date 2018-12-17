
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"货物移动", menuFor: "goodsMovement",
  		subItems: [
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '移动时间', dataIndex: 'moveTime', render: (text, record) =>renderDateTimeCell(text,record)  },
  { title: '设施', debugtype: 'string', dataIndex: 'facility', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '设备ID', debugtype: 'string', dataIndex: 'facilityId', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '从IP', debugtype: 'string', dataIndex: 'fromIp', width: '16',render: (text, record)=>renderTextCell(text,record) },
  { title: '用户代理', debugtype: 'string', dataIndex: 'userAgent', width: '115',render: (text, record)=>renderTextCell(text,record) },
  { title: '会话ID', debugtype: 'string', dataIndex: 'sessionId', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '纬度', debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '经度', debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '货物', dataIndex: 'goods', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  moveTime: '移动时间',
  facility: '设施',
  facilityId: '设备ID',
  fromIp: '从IP',
  userAgent: '用户代理',
  sessionId: '会话ID',
  latitude: '纬度',
  longitude: '经度',
  goods: '货物',

}


const GoodsMovementBase={menuData,displayColumns,fieldLabels,displayColumns}
export default GoodsMovementBase



