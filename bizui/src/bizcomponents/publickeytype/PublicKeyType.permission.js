

import React, { Component } from 'react'
import { connect } from 'dva'
import moment from 'moment'
import BooleanOption from '../../components/BooleanOption';
import { Row, Col, Icon, Card, Tabs, Table, Radio, DatePicker, Tooltip, Menu, Dropdown,Badge, Switch,Select,Form,AutoComplete,Modal } from 'antd'
import { Link, Route, Redirect} from 'dva/router'
import numeral from 'numeral'

import DashboardTool from '../../common/Dashboard.tool'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import styles from './PublicKeyType.profile.less'
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
const internalSummaryOf = (publicKeyType,targetComponent) =>{
    const userContext = null
	return (
	<DescriptionList className={styles.headerList} size="small" col="4">
<Description term="ID">{publicKeyType.id}</Description> 
<Description term="加密算法">{publicKeyType.keyAlg}</Description> 
<Description term="签名算法">{publicKeyType.signAlg}</Description> 
	
      </DescriptionList>
	)
}


const renderPermissionSetting = publicKeyType => {
  const {PublicKeyTypeBase} = GlobalComponents
  return <PermissionSetting targetObject={publicKeyType}  targetObjectMeta={PublicKeyTypeBase}/>
}

const internalRenderExtraHeader = defaultRenderExtraHeader

class PublicKeyTypePermission extends Component {


  componentDidMount() {

  }
  

  render() {
    // eslint-disable-next-line max-len
    const  publicKeyType = this.props.publicKeyType
    const { id,displayName, keyPairIdentityCount } = publicKeyType
    const  returnURL = `/publicKeyType/${id}/workbench`
    const cardsData = {cardsName:"公钥类型",cardsFor: "publicKeyType",cardsSource: publicKeyType,displayName,returnURL,
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
  publicKeyType: state._publicKeyType,
}))(Form.create()(PublicKeyTypePermission))

