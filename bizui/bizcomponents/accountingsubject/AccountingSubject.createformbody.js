import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover,Switch } from 'antd'
import { connect } from 'dva'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import CandidateList from '../../components/CandidateList'
import {ImageComponent} from '../../axios/tools'
import FooterToolbar from '../../components/FooterToolbar'
import styles from './AccountingSubject.createform.less'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import GlobalComponents from '../../custcomponents';
import AccountingSubjectBase from './AccountingSubject.base'
import appLocaleName from '../../common/Locale.tool'
const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input
const {fieldLabels} = AccountingSubjectBase
const testValues = {};
import PrivateImageEditInput from '../../components/PrivateImageEditInput'
import RichEditInput from '../../components/RichEditInput'
import SmallTextInput from '../../components/SmallTextInput'

const imageKeys = [
]


class AccountingSubjectCreateFormBody extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentDidMount() {



    const {initValue} = this.props
    if(!initValue || initValue === null){
      return
    }

    const formValue = AccountingSubjectBase.unpackObjectToFormValues(initValue)
    this.props.form.setFieldsValue(formValue);




  }

  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }




  handleImageChange = (event, source) => {

    const {handleImageChange} = this.props
    if(!handleImageChange){
      console.log('FAILED GET PROCESS FUNCTION TO HANDLE IMAGE VALUE CHANGE', source)
      return
    }

    const { convertedImagesValues } = this.state
    const { fileList } = event
    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    handleImageChange(event, source)


  }


  render() {
    const { form, dispatch, submitting, role } = this.props
    const { convertedImagesValues } = this.state
	const userContext = null
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const { owner } = this.props
    const {AccountingSubjectService} = GlobalComponents

    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    

    const tryinit  = (fieldName) => {

      if(!owner){
      	return null
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return null
      }
      return owner.id
    }

    const availableForEdit= (fieldName) =>{

      if(!owner){
      	return true
      }
      const { referenceName } = owner
      if(referenceName!=fieldName){
        return true
      }
      return false

    }
	const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {

      labelCol: { span: 6 },
      wrapperCol: { span: 12 },

    }

    const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"CreateNew")}{window.trans('accounting_subject')}</div>)
    }

	return (
      <div>
        <Card title={!this.props.hideTitle&&appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
          	<Row gutter={16}>


              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountingSubjectCode} {...formItemLayout}>
                  {getFieldDecorator('accountingSubjectCode', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={2} maxLength={24} size="large"  placeholder={fieldLabels.accountingSubjectCode} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountingSubjectName} {...formItemLayout}>
                  {getFieldDecorator('accountingSubjectName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={2} maxLength={16} size="large"  placeholder={fieldLabels.accountingSubjectName} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountingSubjectClassCode} {...formItemLayout}>
                  {getFieldDecorator('accountingSubjectClassCode', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={0} maxLength={6} size="large"  placeholder={fieldLabels.accountingSubjectClassCode} />
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.accountingSubjectClassName} {...formItemLayout}>
                  {getFieldDecorator('accountingSubjectClassName', {
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
                    <SmallTextInput minLength={1} maxLength={24} size="large"  placeholder={fieldLabels.accountingSubjectClassName} />
                  )}
                </Form.Item>
              </Col>



 
              <Col lg={24} md={24} sm={24} >
                <Form.Item label={fieldLabels.accountSet} {...formItemLayout}>
                  {getFieldDecorator('accountSetId', {
                  	initialValue: tryinit('accountSet'),
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(


                  <CandidateList
		                 disabled={!availableForEdit('accountSet')}
		                 ownerType={owner.type}
		                 ownerId={owner.id}
		                 scenarioCode={"assign"}
		                 listType={"accounting_subject"}
		                 targetType={"account_set"}

                    requestFunction={AccountingSubjectService.queryCandidates}  />



                  )}
                </Form.Item>
              </Col>





			 </Row>
          </Form>
        </Card>









       </div>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(AccountingSubjectCreateFormBody))





