<<<<<<< HEAD

import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'


=======
import React from 'react'
import { Icon,Divider } from 'antd'

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854


const menuData = {menuName:"账套", menuFor: "accountSet",
  		subItems: [
<<<<<<< HEAD
  {name: 'accountingSubjectList', displayName:'会计科目', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountingPeriodList', displayName:'会计期间', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
  {name: 'accountingDocumentTypeList', displayName:'会计凭证类型', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false},
=======
  {name: 'accountingSubjectList', displayName:'会计科目', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingPeriodList', displayName:'会计期间', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingDocumentTypeList', displayName:'会计凭证类型', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
  
  		],
}

<<<<<<< HEAD
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
  { title: '序号', debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'accountSet') },
  { title: '名称', debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: '年组', debugtype: 'string', dataIndex: 'yearSet', width: '9',render: (text, record)=>renderTextCell(text,record) },
  { title: '生效日期', dataIndex: 'effectiveDate', render: (text, record) =>renderDateCell(text,record) },
  { title: '会计制度', debugtype: 'string', dataIndex: 'accountingSystem', width: '11',render: (text, record)=>renderTextCell(text,record) },
  { title: '本币代码', debugtype: 'string', dataIndex: 'domesticCurrencyCode', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '本币名称', debugtype: 'string', dataIndex: 'domesticCurrencyName', width: '7',render: (text, record)=>renderTextCell(text,record) },
  { title: '开户银行', debugtype: 'string', dataIndex: 'openingBank', width: '8',render: (text, record)=>renderTextCell(text,record) },
  { title: '帐户号码', debugtype: 'string', dataIndex: 'accountNumber', width: '18',render: (text, record)=>renderTextCell(text,record) },
  { title: '全国运营中心', dataIndex: 'countryCenter', render: (text, record) => renderReferenceCell(text, record)},
  { title: '双链小超', dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record)},
  { title: '产品供应商', dataIndex: 'goodsSupplier', render: (text, record) => renderReferenceCell(text, record)},
  { title: '最后更新时间', dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

=======

const settingMenuData = {menuName:"账套", menuFor: "accountSet",
  		subItems: [
  
  		],
}

>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
const fieldLabels = {
  id: '序号',
  name: '名称',
  yearSet: '年组',
  effectiveDate: '生效日期',
  accountingSystem: '会计制度',
  domesticCurrencyCode: '本币代码',
  domesticCurrencyName: '本币名称',
  openingBank: '开户银行',
  accountNumber: '帐户号码',
  countryCenter: '全国运营中心',
  retailStore: '双链小超',
  goodsSupplier: '产品供应商',
  lastUpdateTime: '最后更新时间',

}

<<<<<<< HEAD

const AccountSetBase={menuData,displayColumns,fieldLabels,displayColumns}
=======
const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountSet') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.yearSet, debugtype: 'string', dataIndex: 'yearSet', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.effectiveDate, dataIndex: 'effectiveDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountingSystem, debugtype: 'string', dataIndex: 'accountingSystem', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyCode, debugtype: 'string', dataIndex: 'domesticCurrencyCode', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyName, debugtype: 'string', dataIndex: 'domesticCurrencyName', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.openingBank, debugtype: 'string', dataIndex: 'openingBank', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountNumber, debugtype: 'string', dataIndex: 'accountNumber', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countryCenter, dataIndex: 'countryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStore, dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.goodsSupplier, dataIndex: 'goodsSupplier', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(accountSet,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountSet.id}>
	
      <DescriptionList  key={accountSet.id} size="small" col="4">
        <Description term="序号">{accountSet.id}</Description> 
        <Description term="名称">{accountSet.name}</Description> 
        <Description term="年组">{accountSet.yearSet}</Description> 
        <Description term="生效日期"><div>{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term="会计制度">{accountSet.accountingSystem}</Description> 
        <Description term="本币代码">{accountSet.domesticCurrencyCode}</Description> 
        <Description term="本币名称">{accountSet.domesticCurrencyName}</Description> 
        <Description term="开户银行">{accountSet.openingBank}</Description> 
        <Description term="帐户号码">{accountSet.accountNumber}</Description> 
        <Description term="双链小超"><div>{accountSet.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.retailStore.displayName}(${accountSet.retailStore.id})`}
        </div></Description>
        <Description term="产品供应商"><div>{accountSet.goodsSupplier==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.goodsSupplier.displayName}(${accountSet.goodsSupplier.id})`}
        </div></Description>
        <Description term="最后更新时间"><div>{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const AccountSetBase={menuData,displayColumns,fieldLabels,renderItemOfList}
>>>>>>> 502e8b8dfc403300a992b5083e79c722e85d1854
export default AccountSetBase



