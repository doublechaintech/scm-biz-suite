
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'
import appLocaleName from '../../common/Locale.tool'

import { Icon } from 'antd';

const menuData = {menuName:"对象访问", menuFor: "objectAccess",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{
	const userContext = null
	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+appLocaleName(userContext,"Chars")+")"
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


const formatMoney=(amount)=>{
	const options={style: 'decimal',minimumFractionDigits: 2,maximumFractionDigits:2}
    const moneyFormat = new Intl.NumberFormat('en-US',options);
	return moneyFormat.format(amount)
	
}

const renderMoneyCell=(value, record)=>{
	const userContext = null
	if(!value){
		return appLocaleName(userContext,"Empty")
	}
	if(value == null){
		return appLocaleName(userContext,"Empty")
	}
	return (`${appLocaleName(userContext,"Currency")}${formatMoney(value)}`)
}

const renderBooleanCell=(value, record)=>{
	const userContext = null

	return  (value? appLocaleName(userContext,"Yes") : appLocaleName(userContext,"No"))

}

const renderReferenceCell=(value, record)=>{
	const userContext = null
	return (value ? <span style={{fontWeight:"bold"}} title={`${value.id} - ${value.displayName}`} >{value.displayName}</span> : appLocaleName(userContext,"NotAssigned")) 

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


const ObjectAccessBase={menuData,displayColumns,fieldLabels}
export default ObjectAccessBase



