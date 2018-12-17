
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"员工考勤", menuFor: "employeeAttendance",
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
  { title: '员工', dataIndex: 'employee', render: (text, record) => renderReferenceCell(text, record)},
  { title: '进入时间', dataIndex: 'enterTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '离开的时候', dataIndex: 'leaveTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '持续时间', debugtype: 'int', dataIndex: 'durationHours', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '备注', debugtype: 'string', dataIndex: 'remark', width: '11',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  employee: '员工',
  enterTime: '进入时间',
  leaveTime: '离开的时候',
  durationHours: '持续时间',
  remark: '备注',

}


const EmployeeAttendanceBase={menuData,displayColumns,fieldLabels,displayColumns}
export default EmployeeAttendanceBase



