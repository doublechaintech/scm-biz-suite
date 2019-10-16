

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './SupplierProduct.profile.less'
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
const internalSummaryOf = (supplierProduct,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="序号">{supplierProduct.id}</Description> 
<Description term="品名">{supplierProduct.productName}</Description> 
<Description term="产品描述">{supplierProduct.productDescription}</Description> 
<Description term="产品单元">{supplierProduct.productUnit}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = supplierProduct => {
  const {SupplierProductBase} = GlobalComponents
  return <PermissionSetting targetObject={supplierProduct}  targetObjectMeta={SupplierProductBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class SupplierProductPermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  supplierProduct = this.props.supplierProduct
    const { id,displayName, productSupplyDurationCount } = supplierProduct
    const  returnURL = `/supplierProduct/${id}/dashboard`
    const cardsData = {cardsName:"供应商的产品",cardsFor: "supplierProduct",cardsSource: supplierProduct,displayName,returnURL,
  		subItems: [
    
      	],
  	};
    const renderExtraHeader = this.props.renderExtraHeader || internalRenderExtraHeader
    const summaryOf = this.props.summaryOf || internalSummaryOf
   
    return (

      <PageHeaderLayout
        title={internalRenderTitle(cardsData,this)}
        content={summaryOf(cardsData.cardsSource,this)}
        wrapperClassName={styles.advancedForm}
      >
      {renderExtraHeader(cardsData.cardsSource)}
      {renderPermissionSetting(cardsData.cardsSource)}
      
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  supplierProduct: state._supplierProduct,
}))(Form.create()(SupplierProductPermission))

