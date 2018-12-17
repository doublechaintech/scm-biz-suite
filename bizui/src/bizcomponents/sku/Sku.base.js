
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"SKU", menuFor: "sku",
  		subItems: [
  {name: 'goodsList', displayName:'货物', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'sku') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '大小', debugtype: 'string', dataIndex: 'size', width: '5',render: (text, record)=>renderTextCell(text,record) },
  { title: '产品', dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record)},
  { title: '条码', debugtype: 'string', dataIndex: 'barcode', width: '17',render: (text, record)=>renderTextCell(text,record) },
  { title: '包装类型', debugtype: 'string', dataIndex: 'packageType', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '净含量', debugtype: 'string', dataIndex: 'netContent', width: '27',render: (text, record)=>renderTextCell(text,record) },
  { title: '价格', dataIndex: 'price', className:'money', render: (text, record) => renderMoneyCell(text, record) },
  { title: '图片', dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'图片') },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  size: '大小',
  product: '产品',
  barcode: '条码',
  packageType: '包装类型',
  netContent: '净含量',
  price: '价格',
  picture: '图片',

}


const SkuBase={menuData,displayColumns,fieldLabels,displayColumns}
export default SkuBase



