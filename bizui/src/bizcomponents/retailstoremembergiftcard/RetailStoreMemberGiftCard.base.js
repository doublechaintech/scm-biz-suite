
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"零售店会员礼品卡", menuFor: "retailStoreMemberGiftCard",
  		subItems: [
  {name: 'retailStoreMemberGiftCardConsumeRecordList', displayName:'零售商店会员卡消费记录', icon:'gift',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreMemberGiftCard') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '业主', dataIndex: 'owner', render: (text, record) => renderReferenceCell(text, record)},
  { title: '数', debugtype: 'string', dataIndex: 'number', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '保持', dataIndex: 'remain', className:'money', render: (text, record) => renderMoneyCell(text, record) },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  owner: '业主',
  number: '数',
  remain: '保持',

}


const RetailStoreMemberGiftCardBase={menuData,displayColumns,fieldLabels,displayColumns}
export default RetailStoreMemberGiftCardBase



