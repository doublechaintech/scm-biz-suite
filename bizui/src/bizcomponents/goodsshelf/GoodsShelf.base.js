
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"货架", menuFor: "goodsShelf",
  		subItems: [
  {name: 'goodsShelfStockCountList', displayName:'货架库存盘点', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'goodsAllocationList', displayName:'货位', icon:'at',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'goodsShelf') },
  { title: '位置', debugtype: 'string', dataIndex: 'location', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: '存货区', dataIndex: 'storageSpace', render: (text, record) => renderReferenceCell(text, record)},
  { title: '供应商的空间', dataIndex: 'supplierSpace', render: (text, record) => renderReferenceCell(text, record)},
  { title: '残次货物存放区', dataIndex: 'damageSpace', render: (text, record) => renderReferenceCell(text, record)},
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: '序号',
  location: '位置',
  storageSpace: '存货区',
  supplierSpace: '供应商的空间',
  damageSpace: '残次货物存放区',
  lastUpdateTime: '最后更新时间',

}


const GoodsShelfBase={menuData,displayColumns,fieldLabels,displayColumns}
export default GoodsShelfBase



