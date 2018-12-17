
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"用户应用程序", menuFor: "userApp",
  		subItems: [
  {name: 'listAccessList', displayName:'访问列表', icon:'list',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'objectAccessList', displayName:'对象访问', icon:'accessible-icon',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'userApp') },
  { title: '头衔', debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: 'SEC的用户', dataIndex: 'secUser', render: (text, record) => renderReferenceCell(text, record)},
  { title: '应用程序图标', debugtype: 'string', dataIndex: 'appIcon', width: '13',render: (text, record)=>renderTextCell(text,record) },
  { title: '完全访问', dataIndex: 'fullAccess', render: (text, record) =>renderBooleanCell(text, record) },
  { title: '许可', debugtype: 'string', dataIndex: 'permission', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '对象类型', debugtype: 'string', dataIndex: 'objectType', width: '31',render: (text, record)=>renderTextCell(text,record) },
  { title: '对象ID', debugtype: 'string', dataIndex: 'objectId', width: '14',render: (text, record)=>renderTextCell(text,record) },
  { title: '位置', debugtype: 'string', dataIndex: 'location', width: '16',render: (text, record)=>renderTextCell(text,record) },

]

const fieldLabels = {
  id: '序号',
  title: '头衔',
  secUser: 'SEC的用户',
  appIcon: '应用程序图标',
  fullAccess: '完全访问',
  permission: '许可',
  objectType: '对象类型',
  objectId: '对象ID',
  location: '位置',

}


const UserAppBase={menuData,displayColumns,fieldLabels,displayColumns}
export default UserAppBase



