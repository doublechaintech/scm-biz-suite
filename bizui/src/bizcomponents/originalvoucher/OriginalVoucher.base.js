
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"原始凭证", menuFor: "originalVoucher",
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
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '由', debugtype: 'string', dataIndex: 'madeBy', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '受', debugtype: 'string', dataIndex: 'receivedBy', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '凭证类型', debugtype: 'string', dataIndex: 'voucherType', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '凭证图像', dataIndex: 'voucherImage', render: (text, record) => renderImageCell(text,record,'凭证图像') },
  { title: '属于', dataIndex: 'belongsTo', render: (text, record) => renderReferenceCell(text, record)},
  { title: '创建', dataIndex: 'creation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '确认', dataIndex: 'confirmation', render: (text, record) => renderReferenceCell(text, record)},
  { title: '审计', dataIndex: 'auditing', render: (text, record) => renderReferenceCell(text, record)},
  { title: '当前状态', debugtype: 'string', dataIndex: 'currentStatus', width: '13',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  madeBy: '由',
  receivedBy: '受',
  voucherType: '凭证类型',
  voucherImage: '凭证图像',
  belongsTo: '属于',
  creation: '创建',
  confirmation: '确认',
  auditing: '审计',
  currentStatus: '当前状态',

}


const OriginalVoucherBase={menuData,displayColumns,fieldLabels,displayColumns}
export default OriginalVoucherBase



