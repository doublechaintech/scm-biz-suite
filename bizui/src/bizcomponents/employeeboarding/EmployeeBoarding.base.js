
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"员工入职", menuFor: "employeeBoarding",
  		subItems: [
  {name: 'employeeList', displayName:'员工', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'employeeBoarding') },
  { title: '谁', debugtype: 'string', dataIndex: 'who', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '使用时间', dataIndex: 'employTime', render: (text, record) =>renderDateCell(text,record) },
  { title: '评论', debugtype: 'string', dataIndex: 'comments', width: '15',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  who: '谁',
  employTime: '使用时间',
  comments: '评论',

}


const EmployeeBoardingBase={menuData,displayColumns,fieldLabels,displayColumns}
export default EmployeeBoardingBase



