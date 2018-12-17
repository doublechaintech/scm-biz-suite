
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"产品供应时间", menuFor: "productSupplyDuration",
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
  { title: '数量', debugtype: 'int', dataIndex: 'quantity', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '持续时间', debugtype: 'string', dataIndex: 'duration', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '价格', dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '产品', dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  quantity: '数量',
  duration: '持续时间',
  price: '价格',
  product: '产品',

}


const ProductSupplyDurationBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ProductSupplyDurationBase



