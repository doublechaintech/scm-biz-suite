
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"产品", menuFor: "product",
  		subItems: [
  {name: 'skuList', displayName:'SKU', icon:'skull',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'product') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '父类', dataIndex: 'parentCategory', render: (text, record) => renderReferenceCell(text, record)},
  { title: '产地', debugtype: 'string', dataIndex: 'origin', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '备注', debugtype: 'string', dataIndex: 'remark', width: '26',render: (text, record)=>renderTextCell(text,record) },
  { title: '品牌', debugtype: 'string', dataIndex: 'brand', width: '27',render: (text, record)=>renderTextCell(text,record) },
  { title: '图片', dataIndex: 'picture', render: (text, record) => renderImageCell(text,record,'图片') },
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  parentCategory: '父类',
  origin: '产地',
  remark: '备注',
  brand: '品牌',
  picture: '图片',
  lastUpdateTime: '最后更新时间',

}


const ProductBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ProductBase



