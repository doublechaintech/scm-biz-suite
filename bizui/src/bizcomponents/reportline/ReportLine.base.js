
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"报告线", menuFor: "reportLine",
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
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '业主', dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record)},
  { title: '一月', dataIndex: 'january', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '二月', dataIndex: 'february', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '三月', dataIndex: 'march', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '四月', dataIndex: 'april', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '五月', dataIndex: 'may', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '六月', dataIndex: 'june', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '七月', dataIndex: 'july', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '八月', dataIndex: 'august', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '九月', dataIndex: 'september', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '十月', dataIndex: 'october', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '十一月', dataIndex: 'november', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '十二月', dataIndex: 'december', className:'money', render: (text, record) => renderMoneyCell(text, record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  january: '一月',
  february: '二月',
  march: '三月',
  april: '四月',
  may: '五月',
  june: '六月',
  july: '七月',
  august: '八月',
  september: '九月',
  october: '十月',
  november: '十一月',
  december: '十二月',

}


const ReportLineBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ReportLineBase



