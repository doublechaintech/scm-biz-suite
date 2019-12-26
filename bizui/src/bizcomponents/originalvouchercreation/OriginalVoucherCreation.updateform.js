import React, { Component } from 'react'
import { Card, Button, Form, Icon, Col, Row, DatePicker, TimePicker, Input, Select, Popover, Switch } from 'antd'
import moment from 'moment'
import { connect } from 'dva'
import {mapBackToImageValues, mapFromImageValues} from '../../axios/tools'
import PageHeaderLayout from '../../layouts/PageHeaderLayout'
import {ImageComponent} from '../../axios/tools'

import FooterToolbar from '../../components/FooterToolbar'

import styles from './OriginalVoucherCreation.updateform.less'
import OriginalVoucherCreationBase from './OriginalVoucherCreation.base'
import appLocaleName from '../../common/Locale.tool'

const { Option } = Select
const { RangePicker } = DatePicker
const { TextArea } = Input

const imageURLPrefix = '//localhost:2090'

const imageKeys = [
]


class OriginalVoucherCreationUpdateForm extends Component {
  state = {
    previewVisible: false,
    previewImage: '',
    convertedImagesValues: {},
  }

  componentWillMount() {
    const selectedRow = this.getSelectedRow()
    if (!selectedRow) {
      return
    }
    this.setState({
      convertedImagesValues: mapFromImageValues(selectedRow,imageKeys)
    })
  }

  componentDidMount() {

  }

  shouldComponentUpdate() {
    return true
  }

  getSelectedRow() {
    // const { form, dispatch, submitting, selectedRows, currentUpdateIndex } = this.props
    const { selectedRows, currentUpdateIndex } = this.props
    if (!selectedRows) {
      return
    }
    if (currentUpdateIndex >= selectedRows.length) {
      return
    }
    const convertiedValues = selectedRows.map((item) => {
      return {
        ...item,
        makeDate: moment(item.makeDate),

      }
    })
    const selectedRow = convertiedValues[currentUpdateIndex]
    return selectedRow
  }

  handleChange = (event, source) => {
    console.log('get file list from change in update change: ', source)
    const { fileList } = event
    const { convertedImagesValues } = this.state
    convertedImagesValues[source] = fileList
    this.setState({ convertedImagesValues })
    console.log('/get file list from change in update change: ', source)
  }


  handlePreview = (file) => {
    console.log('preview file', file)
    this.setState({
      previewImage: file.url || file.thumbUrl,
      previewVisible: true,
    })
  }

  render() {
    const { form, dispatch, submitting, selectedRows, currentUpdateIndex } = this.props
    const { getFieldDecorator, validateFieldsAndScroll, getFieldsError } = form
    const { convertedImagesValues } = this.state
    const { setFieldsValue } = this.props.form
    const userContext = null
    const {fieldLabels} = OriginalVoucherCreationBase
    const capFirstChar = (value)=>{
    	//const upper = value.replace(/^\w/, c => c.toUpperCase());
  		const upper = value.charAt(0).toUpperCase() + value.substr(1);
  		return upper
  	}
    const submitUpdateForm = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }
		
        const { owner, role } = this.props
        const originalVoucherCreationId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, originalVoucherCreationId, ...imagesValues }

        
        const cappedRoleName = capFirstChar(role)
        dispatch({
          type: `${owner.type}/update${cappedRoleName}`,
          payload: {
            id: owner.id,
            role: role,
            parameters,
            selectedRows,
            currentUpdateIndex: 0,
            continueNext: false,
          },
        })
      })
    }
    
    const submitUpdateFormAndContinue = () => {
      validateFieldsAndScroll((error, values) => {
        if (error) {
          console.log('code go here', error)
          return
        }

        const { owner } = this.props
        const originalVoucherCreationId = values.id
        const imagesValues = mapBackToImageValues(convertedImagesValues)
        const parameters = { ...values, originalVoucherCreationId, ...imagesValues }

        // TODO
        const { currentUpdateIndex } = this.props
        
        if (currentUpdateIndex >= selectedRows.length - 1) {
          return
        }
        this.setState({
          currentUpdateIndex: currentUpdateIndex + 1,
        })
        //setFieldsValue(selectedRows[currentUpdateIndex + 1])
        const newIndex = currentUpdateIndex + 1
        dispatch({
          type: `${owner.type}/updateOriginalVoucherCreation`,
          payload: {
            id: owner.id,
            type: 'originalVoucherCreation',
            parameters,
            selectedRows,
            currentUpdateIndex: newIndex,
            continueNext: true,
          },
        })
      })
    }
    
    const skipToNext = () => {
      const { currentUpdateIndex } = this.props
      const { owner } = this.props
        
      const newIndex = currentUpdateIndex + 1
      dispatch({
        type: `${owner.type}/gotoNextOriginalVoucherCreationUpdateRow`,
        payload: {
          id: owner.id,
          type: 'originalVoucherCreation',
          selectedRows,
          currentUpdateIndex: newIndex,
          continueNext: true,
          update: false,
        },
      })
    }
    
    const goback = () => {
      const { owner } = this.props
      dispatch({
        type: `${owner.type}/goback`,
        payload: {
          id: owner.id,
          type: 'originalVoucherCreation',
          listName:appLocaleName(userContext,"List") 
        },
      })
    }
    const errors = getFieldsError()
    const getErrorInfo = () => {
      const errorCount = Object.keys(errors).filter(key => errors[key]).length
      if (!errors || errorCount === 0) {
        return null
      }
      const scrollToField = (fieldKey) => {
        const labelNode = document.querySelector(`label[for='${fieldKey}']`)
        if (labelNode) {
          labelNode.scrollIntoView(true)
        }
      }
      const errorList = Object.keys(errors).map((key) => {
        if (!errors[key]) {
          return null
        }
        return (
          <li key={key} className={styles.errorListItem} onClick={() => scrollToField(key)}>
            <Icon type="cross-circle-o" className={styles.errorIcon} />
            <div className={styles.errorMessage}>{errors[key][0]}</div>
            <div className={styles.errorField}>{fieldLabels[key]}</div>
          </li>
        )
      })
      return (
        <span className={styles.errorIcon}>
          <Popover
            title={appLocaleName(userContext,"FieldValidateInfo")}
            content={errorList}
            overlayClassName={styles.errorPopover}
            trigger="click"
            getPopupContainer={trigger => trigger.parentNode}
          >
            <Icon type="exclamation-circle" />
          </Popover>
          {errorCount}
        </span>
      )
    }
    
    if (!selectedRows) {
      return (<div>{appLocaleName(userContext,"NoTargetItems")}</div>)
    }
	const selectedRow = this.getSelectedRow()

	const formItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
    }
    const switchFormItemLayout = {
      labelCol: { span: 6 },
      wrapperCol: { span: 12 },
<<<<<<< HEAD
    }
	
	const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"Update")}原始凭证制作: {(currentUpdateIndex+1)}/{selectedRows.length}</div>)
    }

=======
    }
	
	const internalRenderTitle = () =>{
      const linkComp=<a onClick={goback}  > <Icon type="double-left" style={{marginRight:"10px"}} /> </a>
      return (<div>{linkComp}{appLocaleName(userContext,"Update")}原始凭证制作: {(currentUpdateIndex+1)}/{selectedRows.length}</div>)
    }
	
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
	return (
      <PageHeaderLayout
        title={internalRenderTitle()}
        content={`${appLocaleName(userContext,"Update")}${(currentUpdateIndex+1)}/${selectedRows.length}`}
        wrapperClassName={styles.advancedForm}
      >
        <Card title={appLocaleName(userContext,"BasicInfo")} className={styles.card} bordered={false}>
          <Form >
            <Row gutter={16}>
            

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.id} {...formItemLayout}>
                  {getFieldDecorator('id', {
                    initialValue: selectedRow.id,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="序号" disabled/>
=======
                    <Input size="large"  placeHolder={fieldLabels.id} disabled/>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                    
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.who} {...formItemLayout}>
                  {getFieldDecorator('who', {
                    initialValue: selectedRow.who,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="谁" />
=======
                    <Input size="large"  placeHolder={fieldLabels.who} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                    
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.comments} {...formItemLayout}>
                  {getFieldDecorator('comments', {
                    initialValue: selectedRow.comments,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <Input size="large" placeholder="评论" />
=======
                    <Input size="large"  placeHolder={fieldLabels.comments} />
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                    
                  )}
                </Form.Item>
              </Col>

              <Col lg={24} md={24} sm={24}>
                <Form.Item label={fieldLabels.makeDate} {...formItemLayout}>
                  {getFieldDecorator('makeDate', {
                    initialValue: selectedRow.makeDate,
                    rules: [{ required: true, message: appLocaleName(userContext,"PleaseInput") }],
                  })(
<<<<<<< HEAD
                    <DatePicker size="large" format="YYYY-MM-DD" placeholder="制造日期" />
=======
                    <DatePicker size="large" format="YYYY-MM-DD"  placeHolder={fieldLabels.makeDate}/>
>>>>>>> ea67698ef1c4e94c89147baaf9f93aa768973fbe
                    
                  )}
                </Form.Item>
              </Col>

            
       
        
        
        


			</Row>
          </Form>
        </Card>







        <FooterToolbar>
          {getErrorInfo()}
          <Button type="primary" onClick={submitUpdateForm} loading={submitting} htmlType="submit">
            {appLocaleName(userContext,"Update")}
          </Button>
          <Button type="primary" onClick={submitUpdateFormAndContinue} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            {appLocaleName(userContext,"UpdateAndContinue")}
          </Button>
          <Button type="default" onClick={skipToNext} loading={submitting} disabled={currentUpdateIndex + 1 >= selectedRows.length}>
            {appLocaleName(userContext,"Skip")}
          </Button>
          <Button type="default" onClick={goback} loading={submitting}>
            {appLocaleName(userContext,"Cancel")}
          </Button>
        </FooterToolbar>
      </PageHeaderLayout>
    )
  }
}

export default connect(state => ({
  collapsed: state.global.collapsed,
}))(Form.create()(OriginalVoucherCreationUpdateForm))



