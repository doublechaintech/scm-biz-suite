import React from 'react'
<<<<<<< HEAD
import { Icon,Divider } from 'antd'
=======
import { Icon,Divider, Avata, Card, Col} from 'antd'
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'
const { Description } = DescriptionList
<<<<<<< HEAD
=======

>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const {
	defaultRenderReferenceCell,
	defaultRenderBooleanCell,
	defaultRenderMoneyCell,
	defaultRenderDateTimeCell,
	defaultRenderImageCell,
<<<<<<< HEAD
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
=======
	defaultRenderAvatarCell,
	defaultRenderDateCell,
	defaultRenderIdentifier,
	defaultRenderTextCell,
	defaultSearchLocalData,
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
} = BaseTool

const renderTextCell=defaultRenderTextCell
const renderIdentifier=defaultRenderIdentifier
const renderDateCell=defaultRenderDateCell
const renderDateTimeCell=defaultRenderDateTimeCell
const renderImageCell=defaultRenderImageCell
<<<<<<< HEAD
=======
const renderAvatarCell=defaultRenderAvatarCell
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const renderMoneyCell=defaultRenderMoneyCell
const renderBooleanCell=defaultRenderBooleanCell
const renderReferenceCell=defaultRenderReferenceCell


<<<<<<< HEAD
const menuData = {menuName:"账套", menuFor: "accountSet",
  		subItems: [
  {name: 'accountingSubjectList', displayName:'会计科目', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingPeriodList', displayName:'会计期间', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingDocumentTypeList', displayName:'会计凭证类型', icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
=======

const menuData = {menuName: window.trans('account_set'), menuFor: "accountSet",
  		subItems: [
  {name: 'accountingSubjectList', displayName: window.mtrans('accounting_subject','account_set.accounting_subject_list',false), type:'accountingSubject',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingPeriodList', displayName: window.mtrans('accounting_period','account_set.accounting_period_list',false), type:'accountingPeriod',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  {name: 'accountingDocumentTypeList', displayName: window.mtrans('accounting_document_type','account_set.accounting_document_type_list',false), type:'accountingDocumentType',icon:'500px',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
  
  		],
}

<<<<<<< HEAD
=======

const settingMenuData = {menuName: window.trans('account_set'), menuFor: "accountSet",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: window.trans('account_set.id'),
  name: window.trans('account_set.name'),
  yearSet: window.trans('account_set.year_set'),
  effectiveDate: window.trans('account_set.effective_date'),
  accountingSystem: window.trans('account_set.accounting_system'),
  domesticCurrencyCode: window.trans('account_set.domestic_currency_code'),
  domesticCurrencyName: window.trans('account_set.domestic_currency_name'),
  openingBank: window.trans('account_set.opening_bank'),
  accountNumber: window.trans('account_set.account_number'),
  countryCenter: window.trans('account_set.country_center'),
  retailStore: window.trans('account_set.retail_store'),
  goodsSupplier: window.trans('account_set.goods_supplier'),
  lastUpdateTime: window.trans('account_set.last_update_time'),

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'accountSet') , sorter: true },
  { title: fieldLabels.name, debugtype: 'string', dataIndex: 'name', width: '10',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.yearSet, debugtype: 'string', dataIndex: 'yearSet', width: '9',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.effectiveDate, dataIndex: 'effectiveDate', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.accountingSystem, debugtype: 'string', dataIndex: 'accountingSystem', width: '11',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyCode, debugtype: 'string', dataIndex: 'domesticCurrencyCode', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.domesticCurrencyName, debugtype: 'string', dataIndex: 'domesticCurrencyName', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.openingBank, debugtype: 'string', dataIndex: 'openingBank', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.accountNumber, debugtype: 'long', dataIndex: 'accountNumber', width: '18',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countryCenter, dataIndex: 'countryCenter', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.retailStore, dataIndex: 'retailStore', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.goodsSupplier, dataIndex: 'goodsSupplier', render: (text, record) => renderReferenceCell(text, record), sorter:true},
  { title: fieldLabels.lastUpdateTime, dataIndex: 'lastUpdateTime', render: (text, record) =>renderDateTimeCell(text,record), sorter: true},

]


const searchLocalData =(targetObject,searchTerm)=> defaultSearchLocalData(menuData,targetObject,searchTerm)

const renderItemOfList=(accountSet,targetComponent)=>{

  const userContext = null
  return (
    <div key={accountSet.id}>
	
      <DescriptionList  key={accountSet.id} size="small" col="2" >
        <Description term={fieldLabels.id} style={{wordBreak: 'break-all'}}>{accountSet.id}</Description> 
        <Description term={fieldLabels.name} style={{wordBreak: 'break-all'}}>{accountSet.name}</Description> 
        <Description term={fieldLabels.yearSet} style={{wordBreak: 'break-all'}}>{accountSet.yearSet}</Description> 
        <Description term={fieldLabels.effectiveDate}><div>{ moment(accountSet.effectiveDate).format('YYYY-MM-DD')}</div></Description> 
        <Description term={fieldLabels.accountingSystem} style={{wordBreak: 'break-all'}}>{accountSet.accountingSystem}</Description> 
        <Description term={fieldLabels.domesticCurrencyCode} style={{wordBreak: 'break-all'}}>{accountSet.domesticCurrencyCode}</Description> 
        <Description term={fieldLabels.domesticCurrencyName} style={{wordBreak: 'break-all'}}>{accountSet.domesticCurrencyName}</Description> 
        <Description term={fieldLabels.openingBank} style={{wordBreak: 'break-all'}}>{accountSet.openingBank}</Description> 
        <Description term={fieldLabels.accountNumber}><div style={{"color":"red"}}>{accountSet.accountNumber}</div></Description> 
        <Description term={fieldLabels.retailStore}><div>{accountSet.retailStore==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.retailStore.displayName}(${accountSet.retailStore.id})`}
        </div></Description>
        <Description term={fieldLabels.goodsSupplier}><div>{accountSet.goodsSupplier==null?appLocaleName(userContext,"NotAssigned"):`${accountSet.goodsSupplier.displayName}(${accountSet.goodsSupplier.id})`}
        </div></Description>
        <Description term={fieldLabels.lastUpdateTime}><div>{ moment(accountSet.lastUpdateTime).format('YYYY-MM-DD HH:mm')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe

const settingMenuData = {menuName:"账套", menuFor: "accountSet",
  		subItems: [
  
  		],
}
<<<<<<< HEAD

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
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId, goodsSupplierId} = formValuesToPack
	const countryCenter = {id: countryCenterId, version: 2^31}
	const retailStore = {id: retailStoreId, version: 2^31}
	const goodsSupplier = {id: goodsSupplierId, version: 2^31}
	const data = {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenter, retailStore, goodsSupplier}
	return data
}
=======
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId, goodsSupplierId} = formValuesToPack
	const countryCenter = {id: countryCenterId, version: 2^31}
	const retailStore = {id: retailStoreId, version: 2^31}
	const goodsSupplier = {id: goodsSupplierId, version: 2^31}
	const data = {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenter, retailStore, goodsSupplier}
	return data
}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenter, retailStore, goodsSupplier} = objectToUnpack
	const countryCenterId = countryCenter ? countryCenter.id : null
	const retailStoreId = retailStore ? retailStore.id : null
	const goodsSupplierId = goodsSupplier ? goodsSupplier.id : null
	const data = {name, yearSet, effectiveDate, accountingSystem, domesticCurrencyCode, domesticCurrencyName, openingBank, accountNumber, countryCenterId, retailStoreId, goodsSupplierId}
	return data
}
<<<<<<< HEAD

const AccountSetBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
=======
const stepOf=(targetComponent, title, content, position, index)=>{
	return {
		title,
		content,
		position,
		packFunction: packFormValuesToObject,
		unpackFunction: unpackObjectToFormValues,
		index,
      }
}
const AccountSetBase={menuData,displayColumns,fieldLabels,renderItemOfList, stepOf, searchLocalData}
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
export default AccountSetBase



