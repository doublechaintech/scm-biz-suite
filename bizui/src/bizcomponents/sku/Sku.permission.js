

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './Sku.profile.less'
import DescriptionList from '../../components/DescriptionList';

import GlobalComponents from '../../custcomponents';
import PermissionSetting from '../../permission/PermissionSetting'
import appLocaleName from '../../common/Locale.tool'
const { Description } = DescriptionList;
const {defaultRenderExtraHeader}= DashboardTool


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

const internalRenderTitle = (cardsData,targetComponent) =>{
  const linkComp=cardsData.returnURL?<Link to={cardsData.returnURL}> <Icon type="double-left" style={{marginRight:"10px"}} /> </Link>:null
  return (<div>{linkComp}{cardsData.cardsName}: {cardsData.displayName}</div>)

}
const internalSummaryOf = (sku,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{sku.id}</Description> 
<Description term="名称">{sku.name}</Description> 
<Description term="大小">{sku.size}</Description> 
<Description term="条码">{sku.barcode}</Description> 
<Description term="包装类型">{sku.packageType}</Description> 
<Description term="净含量">{sku.netContent}</Description> 
<Description term="价格">{sku.price}</Description> 
<Description term="图片"><ImagePreview imageTitle="图片" imageLocation={sku.picture}/></Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = sku => {
  const {SkuBase} = GlobalComponents
  return <PermissionSetting targetObject={sku}  targetObjectMeta={SkuBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SkuPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  sku = this.props.sku
    const { id,displayName, goodsCount } = sku
    const  returnURL = `/sku/${id}/workbench`
    const cardsData = {cardsName:"SKU",cardsFor: "sku",cardsSource: sku,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
       
        wrapperClassName={styles.advancedForm}
      >
      
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  sku: state._sku,
}))(Form.create()(SkuPermission))

