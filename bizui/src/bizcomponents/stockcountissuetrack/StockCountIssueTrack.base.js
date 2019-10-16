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


const menuData = {menuName:"库存计数问题跟踪", menuFor: "stockCountIssueTrack",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"库存计数问题跟踪", menuFor: "stockCountIssueTrack",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  title: '头衔',
  countTime: '计数时间',
  summary: '概览',
  stockCount: '盘点',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'stockCountIssueTrack') , sorter: true },
  { title: fieldLabels.title, debugtype: 'string', dataIndex: 'title', width: '8',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.countTime, dataIndex: 'countTime', render: (text, record) =>renderDateCell(text,record), sorter: true },
  { title: fieldLabels.summary, debugtype: 'string', dataIndex: 'summary', width: '14',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.stockCount, dataIndex: 'stockCount', render: (text, record) => renderReferenceCell(text, record), sorter:true},

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(stockCountIssueTrack,targetComponent)=>{

  const userContext = null
  return (
    <div key={stockCountIssueTrack.id}>
	
      <DescriptionList  key={stockCountIssueTrack.id} size="small" col="4">
        <Description term="序号">{stockCountIssueTrack.id}</Description> 
        <Description term="头衔">{stockCountIssueTrack.title}</Description> 
        <Description term="计数时间"><div>{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</div></Description> 
        <Description term="概览">{stockCountIssueTrack.summary}</Description> 
        <Description term="盘点"><div>{stockCountIssueTrack.stockCount==null?appLocaleName(userContext,"NotAssigned"):`${stockCountIssueTrack.stockCount.displayName}(${stockCountIssueTrack.stockCount.id})`}
        </div></Description>
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	
const packFormValuesToObject = ( formValuesToPack )=>{
	const {title, countTime, summary, stockCountId} = formValuesToPack
	const stockCount = {id: stockCountId, version: 2^31}
	const data = {title, countTime, summary, stockCount}
	return data
}
const unpackObjectToFormValues = ( objectToUnpack )=>{
	const {title, countTime, summary, stockCount} = objectToUnpack
	const stockCountId = stockCount ? stockCount.id : null
	const data = {title, countTime, summary, stockCountId}
	return data
}

const StockCountIssueTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList,packFormValuesToObject,unpackObjectToFormValues}
export default StockCountIssueTrackBase



