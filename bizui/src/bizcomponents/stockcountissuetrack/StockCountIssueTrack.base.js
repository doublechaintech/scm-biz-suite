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


const menuData = {menuName:"Stock Count Issue Track", menuFor: "stockCountIssueTrack",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  countTime: 'Count Time',
  summary: 'Summary',
  stockCount: 'Stock Count',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record)},
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
<Description term="Id">{stockCountIssueTrack.id}</Description> 
<Description term="Title">{stockCountIssueTrack.title}</Description> 
<Description term="Count Time">{ moment(stockCountIssueTrack.countTime).format('YYYY-MM-DD')}</Description> 
<Description term="Summary">{stockCountIssueTrack.summary}</Description> 
<Description term="Stock Count">{stockCountIssueTrack.stockCount==null?appLocaleName(userContext,"NotAssigned"):`${stockCountIssueTrack.stockCount.displayName}(${stockCountIssueTrack.stockCount.id})`}
</Description>
	
        
      </DescriptionList>
       <Divider style={{ height: '2px' }} />
      </div>
	)

}
	



const StockCountIssueTrackBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default StockCountIssueTrackBase



