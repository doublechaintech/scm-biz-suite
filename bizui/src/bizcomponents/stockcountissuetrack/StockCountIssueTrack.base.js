
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"库存计数问题跟踪", menuFor: "stockCountIssueTrack",
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
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '计数时间', dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '概览', debugtype: 'string', dataIndex: 'summary', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '盘点', dataIndex: 'stockCount', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  countTime: '计数时间',
  summary: '概览',
  stockCount: '盘点',

}


const StockCountIssueTrackBase={menuData,displayColumns,fieldLabels,displayColumns}
export default StockCountIssueTrackBase



