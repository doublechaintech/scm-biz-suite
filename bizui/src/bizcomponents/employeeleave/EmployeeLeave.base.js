
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"请假记录", menuFor: "employeeLeave",
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
  { title: '谁', dataIndex: 'who', render: (text, record) => renderReferenceCell(text, record)},
  { title: '类型', dataIndex: 'type', render: (text, record) => renderReferenceCell(text, record)},
  { title: '请假时长', debugtype: 'int', dataIndex: 'leaveDurationHour', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '备注', debugtype: 'string', dataIndex: 'remark', width: '15',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  who: '谁',
  type: '类型',
  leaveDurationHour: '请假时长',
  remark: '备注',

}


const EmployeeLeaveBase={menuData,displayColumns,fieldLabels,displayColumns}
export default EmployeeLeaveBase



