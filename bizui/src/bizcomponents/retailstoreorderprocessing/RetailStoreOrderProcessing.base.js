import React from 'react'
import { Icon } from 'antd'
import { Link } from 'dva/router'
import moment from 'moment'
import ImagePreview from '../../components/ImagePreview'
import appLocaleName from '../../common/Locale.tool'
import BaseTool from '../../common/Base.tool'
import GlobalComponents from '../../custcomponents'
import DescriptionList from '../../components/DescriptionList'

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


const menuData = {menuName:"生超订单处理", menuFor: "retailStoreOrderProcessing",
  		subItems: [
  {name: 'retailStoreOrderList', displayName:'生超的订单', icon:'store',readPermission: false,createPermission: false,deletePermission: false,updatePermission: false,executionPermission: false, viewGroup: '__no_group'},
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  processTime: '过程的时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '20', render: (text, record)=>renderTextCell(text,record,'retailStoreOrderProcessing') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.processTime, dataIndex: 'processTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=({retailStoreOrderProcessing,targetComponent})=>{

	
	
	const {RetailStoreOrderProcessingService} = GlobalComponents
	// const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{retailStoreOrderProcessing.id}</Description> 
<Description term="谁">{retailStoreOrderProcessing.who}</Description> 
<Description term="过程的时间">{ moment(retailStoreOrderProcessing.processTime).format('YYYY-MM-DD')}</Description> 
	
        {buildTransferModal(retailStoreOrderProcessing,targetComponent)}
      </DescriptionList>
	)

}
	



const RetailStoreOrderProcessingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default RetailStoreOrderProcessingBase



