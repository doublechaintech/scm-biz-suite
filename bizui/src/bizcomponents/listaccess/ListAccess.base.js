
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"访问列表", menuFor: "listAccess",
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
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '6',render: (text, record)=>renderTextCell(text,record) },
  { title: '内部名称', debugtype: 'string', dataIndex: 'internalName', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '读权限', dataIndex: 'readPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '创建权限', dataIndex: 'createPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '删除权限', dataIndex: 'deletePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '更新许可', dataIndex: 'updatePermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '执行权限', dataIndex: 'executionPermission', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '应用程序', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  internalName: '内部名称',
  readPermission: '读权限',
  createPermission: '创建权限',
  deletePermission: '删除权限',
  updatePermission: '更新许可',
  executionPermission: '执行权限',
  app: '应用程序',

}


const ListAccessBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ListAccessBase



