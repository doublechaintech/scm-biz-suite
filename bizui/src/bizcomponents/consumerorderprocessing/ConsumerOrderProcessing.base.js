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


const menuData = {menuName:"消费者的订单处理", menuFor: "consumerOrderProcessing",
  		subItems: [
  
  		],
}


const settingMenuData = {menuName:"消费者的订单处理", menuFor: "consumerOrderProcessing",
  		subItems: [
  
  		],
}

const fieldLabels = {
  id: '序号',
  who: '谁',
  processTime: '过程的时间',

}

const displayColumns = [
  { title: fieldLabels.id, debugtype: 'string', dataIndex: 'id', width: '8', render: (text, record)=>renderTextCell(text,record,'consumerOrderProcessing') , sorter: true },
  { title: fieldLabels.who, debugtype: 'string', dataIndex: 'who', width: '7',render: (text, record)=>renderTextCell(text,record)},
  { title: fieldLabels.processTime, dataIndex: 'processTime', render: (text, record) =>renderDateCell(text,record), sorter: true },

]
// refernce to https://ant.design/components/list-cn/
const renderItemOfList=(consumerOrderProcessing,targetComponent)=>{

  const userContext = null
  return (
    <div key={consumerOrderProcessing.id}>
	
      <DescriptionList  key={consumerOrderProcessing.id} size="small" col="4">
        <Description term="序号">{consumerOrderProcessing.id}</Description> 
        <Description term="谁">{consumerOrderProcessing.who}</Description> 
        <Description term="过程的时间"><div>{ moment(consumerOrderProcessing.processTime).format('YYYY-MM-DD')}</div></Description> 
	
        
      </DescriptionList>
      <Divider style={{ height: '2px' }} />
    </div>
	)

}
	



const ConsumerOrderProcessingBase={menuData,displayColumns,fieldLabels,renderItemOfList}
export default ConsumerOrderProcessingBase



