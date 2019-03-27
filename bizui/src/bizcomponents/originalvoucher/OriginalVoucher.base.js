
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"原始凭证", menuFor: "originalVoucher",
  		subItems: [
  
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


const OriginalVoucherBase={menuData,displayColumns,fieldLabels}
export default OriginalVoucherBase



