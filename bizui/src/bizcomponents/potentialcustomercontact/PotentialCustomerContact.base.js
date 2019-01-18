
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"潜在客户联系", menuFor: "potentialCustomerContact",
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
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '接触日期', dataIndex: 'contactDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '接触法', debugtype: 'string', dataIndex: 'contactMethod', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '潜在的客户', dataIndex: 'potentialCustomer', render: (text, record) => renderReferenceCell(text, record)},
  { title: '城市合伙人', dataIndex: 'cityPartner', render: (text, record) => renderReferenceCell(text, record)},
  { title: '接触', dataIndex: 'contactTo', render: (text, record) => renderReferenceCell(text, record)},
  { title: '描述', debugtype: 'string', dataIndex: 'description', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  contactDate: '接触日期',
  contactMethod: '接触法',
  potentialCustomer: '潜在的客户',
  cityPartner: '城市合伙人',
  contactTo: '接触',
  description: '描述',
  lastUpdateTime: '最后更新时间',

}


const PotentialCustomerContactBase={menuData,displayColumns,fieldLabels,displayColumns}
export default PotentialCustomerContactBase



