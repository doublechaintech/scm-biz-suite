
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"工资支付", menuFor: "payingOff",
  		subItems: [
  {name: 'employeeSalarySheetList', displayName:'工资单', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'payingOff') },
  { title: '谁', debugtype: 'string', dataIndex: 'who', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '支付', dataIndex: 'paidFor', render: (text, record) => renderReferenceCell(text, record)},
  { title: '支付时间', dataIndex: 'paidTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '金额', dataIndex: 'amount', className:'money', render: (text, record) => renderMoneyCell(text, record) },

]

const fieldLabels = {
  id: '序号',
  who: '谁',
  paidFor: '支付',
  paidTime: '支付时间',
  amount: '金额',

}


const PayingOffBase={menuData,displayColumns,fieldLabels,displayColumns}
export default PayingOffBase



