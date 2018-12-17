
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"对象访问", menuFor: "objectAccess",
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
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '对象类型', debugtype: 'string', dataIndex: 'objectType', width: '32',render: (text, record)=>renderTextCell(text,record) },
  { title: '表', debugtype: 'string', dataIndex: 'list1', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '清单', debugtype: 'string', dataIndex: 'list2', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '目录3', debugtype: 'string', dataIndex: 'list3', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '清单', debugtype: 'string', dataIndex: 'list4', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '列表6', debugtype: 'string', dataIndex: 'list5', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'list6', debugtype: 'string', dataIndex: 'list6', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'list7', debugtype: 'string', dataIndex: 'list7', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'list8', debugtype: 'string', dataIndex: 'list8', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: 'list9', debugtype: 'string', dataIndex: 'list9', width: '24',render: (text, record)=>renderTextCell(text,record) },
  { title: '应用程序', dataIndex: 'app', render: (text, record) => renderReferenceCell(text, record)},

]

const fieldLabels = {
  id: '序号',
  name: '名称',
  objectType: '对象类型',
  list1: '表',
  list2: '清单',
  list3: '目录3',
  list4: '清单',
  list5: '列表6',
  list6: 'list6',
  list7: 'list7',
  list8: 'list8',
  list9: 'list9',
  app: '应用程序',

}


const ObjectAccessBase={menuData,displayColumns,fieldLabels,displayColumns}
export default ObjectAccessBase



