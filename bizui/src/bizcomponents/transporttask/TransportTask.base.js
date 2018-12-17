
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"运输任务", menuFor: "transportTask",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'transportTaskTrackList', displayName:'运输任务跟踪', icon:'tasks',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'transportTask') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '开始', debugtype: 'string', dataIndex: 'start', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '开始时间', dataIndex: 'beginTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '结束', dataIndex: 'end', render: (text, record) => renderReferenceCell(text, record)},
  { title: '司机', dataIndex: 'driver', render: (text, record) => renderReferenceCell(text, record)},
  { title: '卡车', dataIndex: 'truck', render: (text, record) => renderReferenceCell(text, record)},
  { title: '属于', dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record)},
  { title: '纬度', debugtype: 'double', dataIndex: 'latitude', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '经度', debugtype: 'double', dataIndex: 'longitude', width: '14',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  start: '开始',
  beginTime: '开始时间',
  end: '结束',
  driver: '司机',
  truck: '卡车',
  belongsTo: '属于',
  latitude: '纬度',
  longitude: '经度',

}


const TransportTaskBase={menuData,displayColumns,fieldLabels,displayColumns}
export default TransportTaskBase



